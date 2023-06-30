package quru.qa.qa_guru_files.model;

public class JsonSample {
    private int id;
    private String name;
    private String idn;
    private JsonSampleModel posList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdn() {
        return idn;
    }

    public void setIdn(String idn) {
        this.idn = idn;
    }

    public JsonSampleModel getJsonSampleModel() {
        return posList;
    }

    public void setJsonSampleModel(JsonSampleModel jsonSampleModel) {
        this.posList = jsonSampleModel;
    }

    public static class JsonSampleModel{
    private String id;
    private String name;
    private String address;
    private boolean status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }

}
