package io.hiker.common.model.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.hiker.common.model.serialize.P2;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FormatVo {
    @JsonSerialize(using = P2.class)
    private Double d1;

}