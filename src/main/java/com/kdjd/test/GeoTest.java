package com.kdjd.test;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeoTest {

    private final static double EARTH_RADIUS = 6378137.0;

    public static void main(String[] args) {
        //int c = 2000;
        //int xyz = 0;
        //for (int i = 0; i < c; i++) {
        //    xyz += i;
        //}
        //System.out.println(xyz);

        List<Location> list = new ArrayList<>();
        /*Random random = new Random();
        for (int i = 0; i < 2000; i++) {
            Location location = new Location();
            location.setLat(30 + random.nextDouble());
            location.setLon(120 + random.nextDouble());
            list.add(location);
        }*/

        //list.add(new Location(20, 20));
        //list.add(new Location(20, -20));
        //list.add(new Location(-20, 20));
        //list.add(new Location(-20, -20));
        //list.add(new Location(-21, -21));


        //list.add(new Location(31.211406, 121.646104));
        //list.add(new Location(31.471406, 120.146104));
        //list.add(new Location(31.371406, 120.146104));
        //list.add(new Location(31.171406, 120.846104));
        //list.add(new Location(31.171406, 120.746104));
        //list.add(new Location(31.171406, 120.346104));
        //list.add(new Location(31.171406, 120.246104));
        //list.add(new Location(31.171406, 120.146104));
        //list.add(new Location(31.161406, 120.746104));
        //list.add(new Location(31.141406, 120.746104));
        //list.add(new Location(31.111406, 120.746104));
        //list.add(new Location(31.111406, 120.646104));
        //list.add(new Location(31.711406, 120.546104));
        //list.add(new Location(31.711406, 120.446104));
        //list.add(new Location(31.711406, 120.346104));
        //list.add(new Location(31.711406, 120.246104));
        //list.add(new Location(31.711406, 120.146104));
        //list.add(new Location(31.711406, 120.646104));
        //list.add(new Location(31.711406, 121.646104));
        //list.add(new Location(31.411406, 121.646104));

        list.add(new Location(30.34509, 120.088447));
        list.add(new Location(30.345103, 120.088445));
        list.add(new Location(30.344815, 120.0883));
        list.add(new Location(30.344815, 120.0883));
        list.add(new Location(30.3451, 120.08844));
        list.add(new Location(30.345073, 120.088449));
        list.add(new Location(30.345096, 120.088447));

        List<Double> res = new ArrayList<>();
        long startAt = System.currentTimeMillis();
        extracted(list, res);
        System.out.println("=== 耗时 : " + (System.currentTimeMillis() - startAt));
        System.out.println("=== 数据量 : " + res.size());
        Stream<Double> sorted = res.stream().sorted(Comparator.reverseOrder());
        System.out.println(sorted.findFirst().get());
        res = new ArrayList<>();
        startAt = System.currentTimeMillis();
        extracted2(list, res);
        System.out.println("=== 耗时 : " + (System.currentTimeMillis() - startAt));
        System.out.println("=== 数据量 : " + res.size());
        sorted = res.stream().sorted(Comparator.reverseOrder());
        System.out.println(sorted.findFirst().get());

    }

    private static void extracted2(List<Location> list, List<Double> res) {
        List<Location> topPoints = getTopPoints(list);

        switch (topPoints.size()) {
            case 1:
                one(res);
                break;
            case 2:
                two(res, topPoints);
                break;
            default:
                four(res, topPoints, list);
        }
    }

    private static List<Location> getTopPoints(List<Location> list) {
        List<Location> topPoints = new ArrayList<>();

        //最小纬度
        Location minLat = list.stream().sorted(Comparator.comparing(Location::getLat)
                .thenComparing(Location::getLon, Comparator.reverseOrder())).collect(Collectors.toList()).get(0);
        //最大纬度
        Location maxLat = list.stream().sorted(Comparator.comparing(Location::getLat, Comparator.reverseOrder())
                .thenComparing(Location::getLon)).collect(Collectors.toList()).get(0);

        // 最大经度
        Location maxLon = list.stream().sorted(Comparator.comparing(Location::getLon, Comparator.reverseOrder())
                .thenComparing(Location::getLat, Comparator.reverseOrder())).collect(Collectors.toList()).get(0);

        // 最大经度
        Location minLon = list.stream().sorted(Comparator.comparing(Location::getLon)
                .thenComparing(Location::getLat)).collect(Collectors.toList()).get(0);

        topPoints.add(minLat);
        topPoints.add(maxLat);
        topPoints.add(maxLon);
        topPoints.add(minLon);

        return topPoints;
    }

    private static void four(List<Double> res, List<Location> topPoints, List<Location> list) {
        List<Point2D.Double> polygon = new ArrayList<>();
        for (Location topPoint : topPoints) {
            polygon.add(new Point2D.Double(topPoint.getLon(), topPoint.getLat()));
        }
        List<Location> outList = new ArrayList<>();

        for (Location location : list) {
            Point2D.Double d = new Point2D.Double();
            d.setLocation(location.getLon(), location.getLat());
            if (!isPointInPoly(d, polygon)) {
                outList.add(location);
            }
        }

        outList.addAll(topPoints);

        extracted(outList, res);
    }

    public static boolean isPointInPoly(Point2D.Double point, List<Point2D.Double> polygon) {
        GeneralPath p = new GeneralPath();
        Point2D.Double first = polygon.get(0);
        p.moveTo(first.x, first.y);
        int size = polygon.size();
        for (int i = 1; i < size; i++) {
            Point2D.Double pa = polygon.get(i);
            p.lineTo(pa.x, pa.y);
        }
        p.lineTo(first.x, first.y);
        p.closePath();
        return p.contains(point);
    }

    private static void two(List<Double> res, List<Location> topPoints) {
        Location from = null, to = null;
        for (Location topPoint : topPoints) {
            if (from == null) {
                from = topPoint;
            } else {
                to = topPoint;
            }
        }
        res.add(distance(from, to));
    }

    private static void one(List<Double> res) {
        res.add((double) 0);
    }

    private static void extracted(List<Location> list, List<Double> res) {
        System.out.println("=== size : " + list.size());
        double maxOne = 0;
        Location maxA = new Location(), maxB = new Location();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Location a = list.get(i);
                Location b = list.get(j);
                if (!(a.getLat() == b.getLat() && a.getLon() == b.getLon())) {
                    double v = distance(a, b);
                    if (v > maxOne) {
                        maxOne = v;
                        maxA = a;
                        maxB = b;
                    }
                    res.add(v);
                }
            }
        }
        System.out.println(maxA);
        System.out.println(maxB);
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

    static class Location {
        private double lat;

        private double lon;

        public Location() {
        }

        public Location(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
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

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("lat", lat)
                    .append("lon", lon)
                    .toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Location location = (Location) o;

            return new EqualsBuilder().append(lat, location.lat).append(lon, location.lon).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(lat).append(lon).toHashCode();
        }
    }
}
