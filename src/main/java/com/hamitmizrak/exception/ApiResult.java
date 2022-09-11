package com.hamitmizrak.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Data
@AllArgsConstructor
@Builder
//React veri giderken bunlar gidecektir.
public class ApiResult {

    private int status;
    private String path;
    private String message;
    private String createdDate;
    // field hakkında bilgi vermek
    private Map<String,Object> validationDataObject;

    private String nowDate(){
        Locale locale=new Locale("tr","TR");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd.MMMM.yyyy HH:mm:ss",locale);
        String change=simpleDateFormat.format(new Date());
        return change;
    }

    public ApiResult() {
        this.createdDate=nowDate();
    }

    public ApiResult(int status, String path, String message) {
        this.status = status;
        this.path = path;
        this.message = message;
        this.createdDate=nowDate();
    }
}
