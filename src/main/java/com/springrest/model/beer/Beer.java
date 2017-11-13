package com.springrest.model.beer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Beer {

        int id;

        String message;

        Data data;

        String status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Beer{" +
                    "message='" + message + '\'' +
                     ", data=" + data + '\'' +
                    "status=" + status +
                    '}';
        }
    }



