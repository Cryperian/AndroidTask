package com.digitain.core.network.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.serialization.json.Json;
import retrofit2.Converter;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class NetworkModule_ProvideConverterFactoryFactory implements Factory<Converter.Factory> {
  private final Provider<Json> jsonProvider;

  private NetworkModule_ProvideConverterFactoryFactory(Provider<Json> jsonProvider) {
    this.jsonProvider = jsonProvider;
  }

  @Override
  public Converter.Factory get() {
    return provideConverterFactory(jsonProvider.get());
  }

  public static NetworkModule_ProvideConverterFactoryFactory create(Provider<Json> jsonProvider) {
    return new NetworkModule_ProvideConverterFactoryFactory(jsonProvider);
  }

  public static Converter.Factory provideConverterFactory(Json json) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideConverterFactory(json));
  }
}
