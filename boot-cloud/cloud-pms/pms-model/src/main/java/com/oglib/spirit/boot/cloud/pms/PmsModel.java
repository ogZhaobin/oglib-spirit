package com.oglib.spirit.boot.cloud.pms;

import lombok.Data;

import java.io.Serializable;

@Data
public class PmsModel implements Serializable {
    private static final long serialVersionUID = -5177080046854782320L;

    public static void main(String[] args) throws InterruptedException {

        Long n1 = new Long(123L);
        Long n2 = new Long(123L);
        System.out.println(n1 == n2);
        try {
            int size = Integer.parseInt(null);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Integer.parseInt(null);
        } finally {
            System.out.println("finally");
        }
    }
}
