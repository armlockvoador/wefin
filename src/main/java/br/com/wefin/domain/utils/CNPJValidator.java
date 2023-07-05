package br.com.wefin.domain.utils;

import org.springframework.stereotype.Component;

@Component
public class CNPJValidator {

    public boolean isValid(String cnpj) {

        if (cnpj.equals("00000000000000") || cnpj.length() != 14) {
            return false;
        }

        int i;
        int j;
        int digit;
        int coeficient;
        int sum;
        int[] foundDv = { 0, 0 };

        int dv1 = Integer.parseInt(String.valueOf(cnpj.charAt(cnpj.length() - 2)));
        int dv2 = Integer.parseInt(String.valueOf(cnpj.charAt(cnpj.length() - 1)));

        for (j = 0; j < 2; j++) {
            sum = 0;
            coeficient = 2;

            for (i = cnpj.length() - 3 + j; i >= 0; i--) {
                digit = Integer.parseInt(String.valueOf(cnpj.charAt(i)));
                sum += digit * coeficient;
                coeficient++;

                if (coeficient > 9) {
                    coeficient = 2;
                }
            }

            foundDv[j] = 11 - sum % 11;

            if (foundDv[j] >= 10) {
                foundDv[j] = 0;
            }
        }

        return dv1 == foundDv[0] && dv2 == foundDv[1];
    }
}
