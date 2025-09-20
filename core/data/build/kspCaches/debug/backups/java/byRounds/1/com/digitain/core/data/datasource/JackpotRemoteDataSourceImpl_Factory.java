package com.digitain.core.data.datasource;

import com.digitain.core.network.api.JackpotApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class JackpotRemoteDataSourceImpl_Factory implements Factory<JackpotRemoteDataSourceImpl> {
  private final Provider<JackpotApiService> apiServiceProvider;

  private JackpotRemoteDataSourceImpl_Factory(Provider<JackpotApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public JackpotRemoteDataSourceImpl get() {
    return newInstance(apiServiceProvider.get());
  }

  public static JackpotRemoteDataSourceImpl_Factory create(
      Provider<JackpotApiService> apiServiceProvider) {
    return new JackpotRemoteDataSourceImpl_Factory(apiServiceProvider);
  }

  public static JackpotRemoteDataSourceImpl newInstance(JackpotApiService apiService) {
    return new JackpotRemoteDataSourceImpl(apiService);
  }
}
