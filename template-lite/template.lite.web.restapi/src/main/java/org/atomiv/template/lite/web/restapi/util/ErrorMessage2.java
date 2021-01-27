package org.atomiv.template.lite.web.restapi.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage2 {
    private int errorCode;
    private String errorMessage;
}
