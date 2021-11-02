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
}
