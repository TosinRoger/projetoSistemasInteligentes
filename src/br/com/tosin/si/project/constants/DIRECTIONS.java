package br.com.tosin.si.project.constants;

/**
 * Created by roger on 19/05/17.
 */
public enum DIRECTIONS {
    N, S, L, O, NO, SO, SD, ND;

    public static DIRECTIONS getDiretionByString(String direction) {
        if (direction.equals(String.valueOf(N)))
            return N;
        else if (direction.equals(String.valueOf(S)))
            return S;
        else if (direction.equals(String.valueOf(L)))
            return L;
        else if (direction.equals(String.valueOf(O)))
            return O;
        else if (direction.equals(String.valueOf(NO)))
            return NO;
        else if (direction.equals(String.valueOf(ND)))
            return ND;
        else if (direction.equals(String.valueOf(SO)))
            return SO;
        else if (direction.equals(String.valueOf(SD)))
            return SD;
        return null;
    }

}
