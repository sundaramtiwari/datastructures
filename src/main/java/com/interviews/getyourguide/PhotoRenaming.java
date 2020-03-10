package com.interviews.getyourguide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PhotoRenaming {

    public static void main(String[] args) {
        String input = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";

        System.out.println(solutionNew(input));
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static public String solutionNew(String S) {
        if (Objects.isNull(S) || S.length() == 0 || S.trim().length() == 0)
            return "";

        String[] inputArr = S.split("\n");

        Map<String, List<Photo>> cityPhotoListMap = new HashMap<>();
        Map<String, Integer> cityPhotoCountMap = new HashMap<>();
        Map<Photo, String> photoNames = new HashMap<>();
        Map<String, Integer> cityPhotoCountTracking = new HashMap<>();

        for (String value : inputArr) {
            String[] textArr = value.split(", ");
            String curName = textArr[0];
            String city = textArr[1];
            Date photoDate = null;
            try {
                photoDate = DATE_FORMAT.parse(textArr[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (!cityPhotoCountTracking.containsKey(city))
                cityPhotoCountTracking.put(city, 1);

            if (cityPhotoListMap.containsKey(city)) {
                List<Photo> photos = cityPhotoListMap.get(city);
                photos.add(new Photo(curName, city, photoDate));
                cityPhotoListMap.put(city, photos);
            } else {
                List<Photo> photos = new ArrayList<>();
                photos.add(new Photo(curName, city, photoDate));
                cityPhotoListMap.put(city, photos);
            }

            if (cityPhotoCountMap.containsKey(city))
                cityPhotoCountMap.put(city, cityPhotoCountMap.get(city) + 1);
            else
                cityPhotoCountMap.put(city, 1);
        }

        for (String city : cityPhotoListMap.keySet()) {
            List<Photo> photos = cityPhotoListMap.get(city);
            Collections.sort(photos);
            cityPhotoListMap.put(city, photos);
        }

        for (String city : cityPhotoListMap.keySet()) {
            List<Photo> photos = cityPhotoListMap.get(city);
            int photoCount = cityPhotoCountMap.get(city);
            int length = (int) (Math.log10(photoCount) + 1);
            String format = "%0" + length + "d";

            for (Photo photo : photos) {
                StringBuilder nameBuilder = new StringBuilder();

                String name = photo.getName();
                String fullName = photo.getName();
                String ext = fullName.split("\\.")[1];

                Integer curCount = cityPhotoCountTracking.get(city);
                cityPhotoCountTracking.put(city, curCount + 1);
                String paddedCount = String.format(format, curCount);
                nameBuilder.append(city).append(paddedCount).append(".").append(ext);

                photoNames.put(photo, nameBuilder.toString());
            }
        }

        List<String> output = new ArrayList<>();
        for (String value : inputArr) {
            String[] textArr = value.split(", ");
            String curName = textArr[0];
            String city = textArr[1];
            Date photoDate = null;
            try {
                photoDate = DATE_FORMAT.parse(textArr[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Photo photo = new Photo(curName, city, photoDate);
            output.add(photoNames.get(photo));
        }

        return String.join("\n", output);
    }

    static public String solution(String S) throws ParseException {
        String[] inputArr = S.split("\n");

        Map<Photo, String> photoMap = new HashMap<>();
        Map<String, Integer> cityPhotoCountMap = new HashMap<>();
        Map<String, Integer> cityPhotoCountTracking = new HashMap<>();
        //List<String> citySequence
        for (String value : inputArr) {
            String[] textArr = value.split(", ");
            String city = textArr[1];

            if (!cityPhotoCountTracking.containsKey(city))
                cityPhotoCountTracking.put(city, 1);

            if (cityPhotoCountMap.containsKey(city))
                cityPhotoCountMap.put(city, cityPhotoCountMap.get(city) + 1);
            else
                cityPhotoCountMap.put(city, 1);
        }

        List<String> output = new ArrayList<>();
        for (String s : inputArr) {
            String[] textArr = s.split(", ");
            StringBuilder nameBuilder = new StringBuilder();
            String curName = textArr[0];
            String[] extArr = curName.split("\\.");
            String ext = extArr[1];
            String city = textArr[1];
            nameBuilder.append(city);

            int photoCount = cityPhotoCountMap.get(city) + 1;
            cityPhotoCountMap.put(city, photoCount);
            int length = (int) (Math.log10(photoCount) + 1);
            String format = "%0" + length + "d";
            Integer curCount = cityPhotoCountTracking.get(city);
            cityPhotoCountTracking.put(city, curCount + 1);
            String paddedCount = String.format(format, curCount);

            nameBuilder.append(paddedCount).append(".").append(ext);

            Date photoDate = DATE_FORMAT.parse(textArr[2]);
            Photo photo = new Photo(curName, city, photoDate);
            photoMap.put(photo, paddedCount);
            //output.add(nameBuilder.toString());
        }

        return String.join("\n", output);
    }

    static class Photo implements Comparable<Photo> {
        private String name;
        private String city;
        private Date date;

        public Photo(String name, String city, Date date) {
            this.name = name;
            this.city = city;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }

        public Date getDate() {
            return date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Photo photo = (Photo) o;
            return name.equals(photo.getName()) &&
                    city.equals(photo.getCity()) &&
                    date.equals(photo.getDate());
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, city, date);
        }

        @Override
        public int compareTo(Photo o) {
            return getDate().compareTo(o.getDate());
        }
    }
}
