package com.kdjd.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class GatherTest {

    private static final Logger log = LoggerFactory.getLogger(GatherTest.class);

    private final static double EARTH_RADIUS = 6378137.0;

    public static void main(String[] args) {
        int size = 200;
        List<Long> aPks = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            aPks.add((long) i);
        }

        long pkId = 1;
        List<Location> list = new ArrayList<>();
        Random random = new Random();
        for (Long aPk : aPks) {
            for (int i = 1; i <= 1000; i++) {
                Location location = new Location();
                location.setPkId(pkId++);
                location.setaPk(aPk);
                location.setLat(30 + random.nextDouble());
                location.setLon(120 + random.nextDouble());
                location.setVtime(getRandomDate(random));
                list.add(location);
            }
        }
        Map<Long, List<Location>> longListMap;
        long l = System.currentTimeMillis();
        longListMap = extracted2(list);
        long s = System.currentTimeMillis();
        log.info("耗时：{}， 结果： {}", (s - l), longListMap.size());

        l = System.currentTimeMillis();
        longListMap = extracted(list);
        s = System.currentTimeMillis();
        log.info("耗时：{}， 结果： {}", (s - l), longListMap.size());
    }

    private static Date getRandomDate(Random random) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, random.nextInt(24));
        cal.set(Calendar.MINUTE, random.nextInt(60));
        cal.set(Calendar.SECOND, random.nextInt(60));
        return cal.getTime();
    }

    private static Map<Long, List<Location>> extracted2(List<Location> list) {
        List<Future<Map<Long, List<Location>>>> res = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(24);

        Map<Long, List<Location>> map = new HashMap<>();
        //按时间排序
        List<Location> collect = list.stream().sorted(Comparator.comparing(Location::getVtime)).collect(Collectors.toList());
        for (Location location : collect) {
            Task task = new Task();
            task.setCollect(collect);
            task.setLocation(location);
            Future<Map<Long, List<Location>>> o = executor.submit(task);
            res.add(o);
        }
        executor.shutdown();

        for (Future<Map<Long, List<Location>>> r : res) {
            try {
                Map<Long, List<Location>> re = r.get();
                log.info("re size : {}", re.size());
                map.putAll(re);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        return map;
    }

    private static Map<Long, List<Location>> extracted(List<Location> list) {
        GeoHashHelper geoHashHelper = new GeoHashHelper();
        long start = System.currentTimeMillis();
        System.out.println(geoHashHelper.around(44.9999, 116.3967));
        System.out.println(geoHashHelper.around(45.0001, 116.3967));
        System.out.println("waste time: " + (System.currentTimeMillis() - start));


        return new HashMap<>();
    }

    private static double distance(Location from, Location to) {
        return distance(from.getLat(), from.getLon(), to.getLat(), to.getLon());
    }

    public static double distance(double fromLat, double fromLng, double toLat, double toLng) {
        double pi180 = Math.PI / 180;
        double arcLatA = fromLat * pi180;
        double arcLatB = toLat * pi180;
        double x = (Math.cos(arcLatA) * Math.cos(arcLatB) * Math.cos((fromLng - toLng) * pi180));
        double y = Math.sin(arcLatA) * Math.sin(arcLatB);
        double s = x + y;
        if (s > 1) {
            s = 1;
        }
        if (s < -1) {
            s = -1;
        }
        double alpha = Math.acos(s);
        return alpha * EARTH_RADIUS;
    }

    static class Task implements Callable<Map<Long, List<Location>>> {

        private Location location;

        private List<Location> collect;

        @Override
        public Map<Long, List<Location>> call() {
            if (CollectionUtils.isEmpty(collect)) {
                return new HashMap<>();
            }
            int dur = 1000;

            Map<Long, List<Location>> map = new HashMap<>();
            double scope = dur * 0.00001;
            Date start = location.getVtime();
            Date end = DateUtils.addHours(start, 1);
            List<Location> filter = collect.stream().filter(o ->
                    o.getaPk() != location.getaPk() &&
                            o.getVtime().after(start) &&
                            o.getVtime().before(end) &&
                            o.getLat() > (location.getLat() - scope) &&
                            o.getLat() < (location.getLat() + scope) &&
                            o.getLon() > (location.getLon() - scope) &&
                            o.getLon() > (location.getLon() + scope)
            ).collect(Collectors.toList());

            for (Location f : filter) {
                double distance = distance(location, f);
                if (distance < dur) {
                    if (map.get(location.getPkId()) == null) {
                        map.put(location.pkId, new ArrayList<>());
                    }
                    map.get(location.getPkId()).add(f);
                }
            }
            return map;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public List<Location> getCollect() {
            return collect;
        }

        public void setCollect(List<Location> collect) {
            this.collect = collect;
        }
    }


    static class Location {
        private long pkId;
        private long aPk;
        private double lat;
        private double lon;
        @JSONField(format = "yyyy-MM-dd hh:mm:ss")
        private Date vtime;

        public Location() {
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }

        public long getPkId() {
            return pkId;
        }

        public void setPkId(long pkId) {
            this.pkId = pkId;
        }

        public long getaPk() {
            return aPk;
        }

        public void setaPk(long aPk) {
            this.aPk = aPk;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public Date getVtime() {
            return vtime;
        }

        public void setVtime(Date vtime) {
            this.vtime = vtime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Location location = (Location) o;

            return new EqualsBuilder().append(pkId, location.pkId).append(aPk, location.aPk).append(lat, location.lat).append(lon, location.lon).append(vtime, location.vtime).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(pkId).append(aPk).append(lat).append(lon).append(vtime).toHashCode();
        }
    }

}
