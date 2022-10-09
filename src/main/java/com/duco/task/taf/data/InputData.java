package com.duco.task.taf.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InputData {

    private String validFormatShortInput;

    private String validFormatSentence;

    private String invalidDataFormat;
}