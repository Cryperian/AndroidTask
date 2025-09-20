package com.digitain.core.network.di;

import com.digitain.core.network.api.JackpotApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvideJackpotApiServiceFactory implements Factory<JackpotApiService> {
  private final Provider<Retrofit> retrofitProvider;

  private NetworkModule_ProvideJackpotApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public JackpotApiService get() {
    return provideJackpotApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideJackpotApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideJackpotApiServiceFactory(retrofitProvider);
  }

  public static JackpotApiService provideJackpotApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideJackpotApiService(retrofit));
  }
}
