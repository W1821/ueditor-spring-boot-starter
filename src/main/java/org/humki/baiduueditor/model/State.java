package org.humki.baiduueditor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 判断成功失败基本对象
 *
 * @author Kael
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class State {

    /**
     * 成功返回SUCCESS，是否返回其他字符串
     */
    private String state;


}
