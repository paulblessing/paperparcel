/*
 * Copyright (C) 2016 Bradley Campbell.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package paperparcel;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * <p>Annotate {@link TypeAdapter} classes with this to register them in PaperParcel's type
 * system.</p>
 *
 * @deprecated Use {@link ProcessorConfig} instead.
 */
@Deprecated
@Documented
@Retention(SOURCE)
@Target(TYPE)
public @interface RegisterAdapter {
  /**
   * Return {@code true} if this type {@link TypeAdapter} can handle {@code null}s or doesn't
   * need to (i.e. the {@link TypeAdapter} is parcelling a non-nullable type). If this returns
   * {@code false} (the default), then PaperParcel will do null-checking for you. Returning
   * {@code true} from this method can help by preventing double (or completely unnecessary)
   * null-checking.
   */
  boolean nullSafe() default false;
}
