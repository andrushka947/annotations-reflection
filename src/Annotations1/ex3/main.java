package Annotations1.ex3;


public class main {
    public static void main(String[] args) throws Exception {
        Tester tester = new Tester();
        tester.setName("bye,man1");
        tester.setAge(4);
        tester.setPi(3.14);
        tester.setCharacter('b');

        String res = Serializer.serialize(tester);
        System.out.println("Serialized: " + res);

        tester = Serializer.deserialize(res, Tester.class);
        System.out.println("Deserialized: " + tester.getName() + ", " + tester.getPi() +
        ", " + tester.getAge() + ", " + tester.getCharacter() + ", \n OLD VALUES:" + tester.getCharacter1()
        + ", " + tester.getSrt() );
    }
}
