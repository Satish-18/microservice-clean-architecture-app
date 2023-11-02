// Auto generated by io.soabase.recordbuilder.core.RecordBuilder: https://github.com/Randgalt/record-builder
package citytech.global.sapatide.platform.rest;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;
import javax.annotation.processing.Generated;

@Generated("io.soabase.recordbuilder.core.RecordBuilder")
public class RestResponseBuilder<T> {
    private String code;

    private String message;

    private T data;

    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    private RestResponseBuilder() {
    }

    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    private RestResponseBuilder(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Static constructor/builder. Can be used instead of new RestResponse(...)
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public static <T> RestResponse<T> RestResponse(String code, String message, T data) {
        return new RestResponse<T>(code, message, data);
    }

    /**
     * Return a new builder with all fields set to default Java values
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public static <T> RestResponseBuilder<T> builder() {
        return new RestResponseBuilder<T>();
    }

    /**
     * Return a new builder with all fields set to the values taken from the given record instance
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public static <T> RestResponseBuilder<T> builder(RestResponse<T> from) {
        return new RestResponseBuilder<T>(from.code(), from.message(), from.data());
    }

    /**
     * Return a "with"er for an existing record instance
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public static <T> RestResponseBuilder.With<T> from(RestResponse<T> from) {
        return new _FromWith<>(from);
    }

    /**
     * Return a stream of the record components as map entries keyed with the component name and the value as the component value
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public static <T> Stream<Map.Entry<String, Object>> stream(RestResponse<T> record) {
        return Stream.of(new AbstractMap.SimpleImmutableEntry<>("code", record.code()),
                 new AbstractMap.SimpleImmutableEntry<>("message", record.message()),
                 new AbstractMap.SimpleImmutableEntry<>("data", record.data()));
    }

    /**
     * Return a new record instance with all fields set to the current values in this builder
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public RestResponse<T> build() {
        return new RestResponse<T>(code, message, data);
    }

    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    @Override
    public String toString() {
        return "RestResponseBuilder[code=" + code + ", message=" + message + ", data=" + data + "]";
    }

    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    @Override
    public int hashCode() {
        return Objects.hash(code, message, data);
    }

    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    @Override
    public boolean equals(Object o) {
        return (this == o) || ((o instanceof RestResponseBuilder<?> r)
                && Objects.equals(code, r.code)
                && Objects.equals(message, r.message)
                && Objects.equals(data, r.data));
    }

    /**
     * Set a new value for the {@code code} record component in the builder
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public RestResponseBuilder<T> code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Return the current value for the {@code code} record component in the builder
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public String code() {
        return code;
    }

    /**
     * Set a new value for the {@code message} record component in the builder
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public RestResponseBuilder<T> message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Return the current value for the {@code message} record component in the builder
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public String message() {
        return message;
    }

    /**
     * Set a new value for the {@code data} record component in the builder
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public RestResponseBuilder<T> data(T data) {
        this.data = data;
        return this;
    }

    /**
     * Return the current value for the {@code data} record component in the builder
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public T data() {
        return data;
    }

    /**
     * Add withers to {@code RestResponse}
     */
    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    public interface With<T> {
        /**
         * Return the current value for the {@code code} record component in the builder
         */
        @Generated("io.soabase.recordbuilder.core.RecordBuilder")
        String code();

        /**
         * Return the current value for the {@code message} record component in the builder
         */
        @Generated("io.soabase.recordbuilder.core.RecordBuilder")
        String message();

        /**
         * Return the current value for the {@code data} record component in the builder
         */
        @Generated("io.soabase.recordbuilder.core.RecordBuilder")
        T data();

        /**
         * Return a new record builder using the current values
         */
        @Generated("io.soabase.recordbuilder.core.RecordBuilder")
        default RestResponseBuilder<T> with() {
            return new RestResponseBuilder<>(code(), message(), data());
        }

        /**
         * Return a new record built from the builder passed to the given consumer
         */
        @Generated("io.soabase.recordbuilder.core.RecordBuilder")
        default RestResponse<T> with(Consumer<RestResponseBuilder<T>> consumer) {
            RestResponseBuilder<T> builder = with();
            consumer.accept(builder);
            return builder.build();
        }

        /**
         * Return a new instance of {@code RestResponse} with a new value for {@code code}
         */
        @Generated("io.soabase.recordbuilder.core.RecordBuilder")
        default RestResponse<T> withCode(String code) {
            return new RestResponse<T>(code, message(), data());
        }

        /**
         * Return a new instance of {@code RestResponse} with a new value for {@code message}
         */
        @Generated("io.soabase.recordbuilder.core.RecordBuilder")
        default RestResponse<T> withMessage(String message) {
            return new RestResponse<T>(code(), message, data());
        }

        /**
         * Return a new instance of {@code RestResponse} with a new value for {@code data}
         */
        @Generated("io.soabase.recordbuilder.core.RecordBuilder")
        default RestResponse<T> withData(T data) {
            return new RestResponse<T>(code(), message(), data);
        }
    }

    @Generated("io.soabase.recordbuilder.core.RecordBuilder")
    private static final class _FromWith<T> implements RestResponseBuilder.With<T> {
        private final RestResponse<T> from;

        @Generated("io.soabase.recordbuilder.core.RecordBuilder")
        private _FromWith(RestResponse<T> from) {
            this.from = from;
        }

        @Override
        @Generated("io.soabase.recordbuilder.core.RecordBuilder")
        public String code() {
            return from.code();
        }

        @Override
        @Generated("io.soabase.recordbuilder.core.RecordBuilder")
        public String message() {
            return from.message();
        }

        @Override
        @Generated("io.soabase.recordbuilder.core.RecordBuilder")
        public T data() {
            return from.data();
        }
    }
}