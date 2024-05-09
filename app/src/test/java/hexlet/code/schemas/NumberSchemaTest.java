//package hexlet.code.schemas;
//
//import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class NumberSchemaTest {
//    private static final int TEN = 10;
//    private static final int NEGATIVE_ONE = -1;
//    private static final int ZERO = 0;
//    private static final int FIVE = 5;
//    private static final int FIFTEEN = 15;
//    private static final int FOUR = 4;
//    private static final int SIXTEEN = 16;
//    private static final int TWENTY = 20;
//    private static final int TWENTY_ONE = 21;
//    private static final int NINE = 9;
//
//    @Test
//    public void testPositive() {
//        NumberSchema schema = new NumberSchema().positive();
//        assertThat(schema.isValid(TEN)).isTrue();
//        assertThat(schema.isValid(NEGATIVE_ONE)).isFalse();
//        assertThat(schema.isValid(ZERO)).isFalse();
//    }
//
//    @Test
//    public void testRange() {
//        NumberSchema schema = new NumberSchema().range(FIVE, FIFTEEN);
//        assertThat(schema.isValid(TEN)).isTrue();
//        assertThat(schema.isValid(FIVE)).isTrue();
//        assertThat(schema.isValid(FIFTEEN)).isTrue();
//        assertThat(schema.isValid(FOUR)).isFalse();
//        assertThat(schema.isValid(SIXTEEN)).isFalse();
//    }
//
//    @Test
//    public void testRequiredPositiveRange() {
//        NumberSchema schema = new NumberSchema().required().positive().range(TEN, TWENTY);
//        assertThat(schema.isValid(null)).isFalse();
//        assertThat(schema.isValid(NINE)).isFalse();
//        assertThat(schema.isValid(TEN)).isTrue();
//        assertThat(schema.isValid(TWENTY)).isTrue();
//        assertThat(schema.isValid(TWENTY_ONE)).isFalse();
//    }
//
//    @Test
//    public void testHandlingNullWithoutRequired() {
//        NumberSchema schema = new NumberSchema();
//        assertThat(schema.isValid(null)).isTrue();
//    }
//}
