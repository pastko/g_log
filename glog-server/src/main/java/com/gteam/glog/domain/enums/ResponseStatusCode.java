package com.gteam.glog.domain.enums;


/**
 * Response Status Code
 *
 *
 */
public enum ResponseStatusCode {
    OK(200),
    CREATE(201),
    NOCONTENTS(204),
    BADREQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOTFOUND(404);

    private int values;
    ResponseStatusCode(int values){
        this.values = values;
    }
    public int get(){
        return this.values;
    }
    public String getMsg(){
        switch (this.values){
            case 200:
                return "OK";
            case 201:
                return "Create";
            case 204:
                return "No content";
            case 400:
                return "Bad Request";
            case 401:
                return "Unauthorized";
            case 403:
                return "Forbidden";
            case 404:
                return "Not Found";
            case 500:
                return "Internal Server Error";
            default:
                return "";
        }
    }
}
