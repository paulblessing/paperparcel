package nz.bradcampbell.dataparcel;

import com.google.common.base.Joiner;
import com.google.testing.compile.JavaFileObjects;
import org.junit.Test;

import javax.tools.JavaFileObject;

import static com.google.common.truth.Truth.assertAbout;
import static com.google.testing.compile.JavaSourceSubjectFactory.javaSource;

public class InvalidTypeTest {

  @Test public void noGetterMethodTest() throws Exception {
    JavaFileObject source = JavaFileObjects.forSourceString("test.Test", Joiner.on('\n').join(
        "package test;",
        "import nz.bradcampbell.dataparcel.DataParcel;",
        "@DataParcel",
        "public final class Test {",
        "private final String testString;",
        "public Test(String testString) {",
        "this.testString = testString;",
        "}",
        "}"
    ));

    assertAbout(javaSource()).that(source)
        .processedWith(new DataParcelProcessor())
        .failsToCompile();
  }

  @Test public void genericArrayTest() throws Exception {
    JavaFileObject source = JavaFileObjects.forSourceString("test.Test", Joiner.on('\n').join(
        "package test;",
        "import nz.bradcampbell.dataparcel.DataParcel;",
        "import android.util.SparseArray;",
        "import java.util.List;",
        "@DataParcel",
        "public final class Test {",
        "private final SparseArray<String>[] child;",
        "public Test(SparseArray<String>[] child) {",
        "this.child = child;",
        "}",
        "public SparseArray<String>[] component1() {",
        "return this.child;",
        "}",
        "}"
    ));

    assertAbout(javaSource()).that(source)
        .processedWith(new DataParcelProcessor())
        .compilesWithoutError();
  }
}