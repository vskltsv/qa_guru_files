package quru.qa.qa_guru_files.model;

import java.util.List;

public class JsonSample {
    private int id;
    private String name;
    private String idn;
    private List<PosList> posList;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdn() {
        return idn;
    }

    public List<PosList> getPosList() {
        return posList;
    }

    public static class PosList {
    private String id;
    private String name;
    private String address;
    private boolean status;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public boolean isStatus() {
            return status;
        }
    }

}
