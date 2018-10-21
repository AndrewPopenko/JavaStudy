package horstman.part.oop.reflection_test;

public class ReflectionAndEnum {

    enum openenum {
        ONE, TWO
    }

    public static class EnumPublic {
        public enum enumpublic {
            ONE, TWO
        }

        enumpublic ep;

        EnumPublic() {
            System.out.println("EnumPublic");
        }
    }

    public static class EnumPrivate {
        private enum enumprivate {
            ONE, TWO
        }

        EnumPrivate() {
            System.out.println("EnumPrivate");
        }
    }

    public static void main(String[] args) {
        EnumPublic enumPublic = new EnumPublic();
        //Class c = enumPublic.getClass().getEnumConstants();

       // Field f[] = (Field[]) c.getEnumConstants();

        try {
            Object[] ee =  enumPublic.getClass().getEnumConstants();

            for (Object e : ee) {
                System.out.println(e);
            }
        }
        catch (NullPointerException e) {
            System.out.println("ne udalos wernut enum");
        }



    }
}
