import java.util.Random;

public class Expression_Builder {
    public String getExpression() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(getFirstTerm());

        stringBuilder.append(getOperation());

        stringBuilder.append("(" + getNumeratorForSecondTerm() +"/" + getDenominatorForSecondTerm() + ")");

        return stringBuilder.toString();
    }

    private String getFirstTerm() {
        return "1";
    }

    private String getOperation() {
        final double probabilityPositive = 0.5;
        double randomNumber = Math.random();

        if (randomNumber <= probabilityPositive) {
            return "+";
        } else {
            return "-";
        }
    }

    private String getNumeratorForSecondTerm() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        final double probabilityOfConstantVsVariable = 0.5;

        final int minEntities = 1;
        final int maxEntities = 2;

        stringBuilder.append("(");


        double randomNumber = Math.random();
        int numEntities = random.nextInt(maxEntities);
        numEntities += 1;

        if (numEntities == 1) {
            randomNumber = Math.random();

            if (randomNumber <= probabilityOfConstantVsVariable) {
                stringBuilder.append(getConstant());
            } else {
                stringBuilder.append(getVariable());
            }
        }

        if (numEntities > 1) {
            int iterator = 0;

            while (iterator < (numEntities-1)) {
            randomNumber = Math.random();

            if (randomNumber <= probabilityOfConstantVsVariable) {
                stringBuilder.append(getConstant());
            } else {
                stringBuilder.append(getVariable());
            }

            stringBuilder.append(getOperation());

            iterator++;
            }

            randomNumber = Math.random();

            if (randomNumber <= probabilityOfConstantVsVariable) {
                stringBuilder.append(getConstant());
            } else {
                stringBuilder.append(getVariable());
            }
        }

        stringBuilder.append(")");


        return stringBuilder.toString();
    }

    private String getDenominatorForSecondTerm() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        final double probabilityOfFirstEntityMultiplyRemainingEntities = 0.75;
        final double probabilityOfConstantVsVariable = 0.5;


        final int minEntities = 1;
        final int maxEntities = 3;


        stringBuilder.append("(");


        double randomNumber = Math.random();
        int numEntities = random.nextInt(maxEntities);
        numEntities+=1;


        // is the denominator in the format p(p-1), with first p being the first entity
        boolean doesFirstEntityMultiplyRemainingEntities = (numEntities >= 2) && (randomNumber <= probabilityOfFirstEntityMultiplyRemainingEntities);

        if (doesFirstEntityMultiplyRemainingEntities) {
            randomNumber = Math.random();

            if (randomNumber <= probabilityOfConstantVsVariable) {
                stringBuilder.append(getConstant());
            } else {
                stringBuilder.append(getVariable());
            }

            stringBuilder.append("*(");

            for (int i = 0; i < numEntities-1; i++){
                randomNumber = Math.random();

                if (randomNumber <= probabilityOfConstantVsVariable) {
                    stringBuilder.append(getConstant());
                } else {
                    stringBuilder.append(getVariable());
                }

                if ((numEntities-(i+1)) > 1) {
                    stringBuilder.append(getOperation());
                }

                if ((i == (numEntities-2))) {
                    stringBuilder.append(")"); // ONLY FOR IF doesFirstEntityMultiplyRemainingEntities == TRUE
                }
            }

        } else {
            for (int i = 0; i < numEntities; i++) {
                randomNumber = Math.random();

                if (randomNumber <= probabilityOfConstantVsVariable) {
                    stringBuilder.append(getConstant());
                } else {
                    stringBuilder.append(getVariable());
                }

                if ((numEntities-i) > 1) {
                    stringBuilder.append(getOperation());
                }
            }
        }

        stringBuilder.append(")");


        return stringBuilder.toString();
    }

    private String getVariable() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        final double probabilityOfCoefficient = 0.5;
        final double probabilityOfExponent = 0.125;

        final int minCoefficient = 1;
        final int maxCoefficient = 4;

        final int minExponent = 2;
        final int maxExponent = 3;

        double randomNumber = Math.random();

        if (randomNumber <= probabilityOfCoefficient) {
            int coefficient = random.nextInt(maxCoefficient);
            coefficient+=1;

            stringBuilder.append(coefficient);
        }

        stringBuilder.append("p");

        randomNumber = Math.random();

        if (randomNumber <= probabilityOfExponent) {
            int exponent = random.nextInt(maxExponent);
            exponent+=1;

            stringBuilder.append("^" + exponent);
        }

        return stringBuilder.toString();
    }

    private String getConstant() {
        Random random = new Random();

        final int minConstant = 1;
        final int maxConstant = 3;

        return String.valueOf((random.nextInt(maxConstant))+1);
    }
}
