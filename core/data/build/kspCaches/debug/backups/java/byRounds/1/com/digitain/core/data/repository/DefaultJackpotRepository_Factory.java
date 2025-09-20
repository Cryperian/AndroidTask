package com.digitain.core.data.repository;

import com.digitain.core.data.datasource.JackpotRemoteDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("com.digitain.core.data.di.Dispatcher")
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
public final class DefaultJackpotRepository_Factory implements Factory<DefaultJackpotRepository> {
  private final Provider<JackpotRemoteDataSource> remoteDataSourceProvider;

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  private final Provider<CoroutineDispatcher> defaultDispatcherProvider;

  private DefaultJackpotRepository_Factory(
      Provider<JackpotRemoteDataSource> remoteDataSourceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<CoroutineDispatcher> defaultDispatcherProvider) {
    this.remoteDataSourceProvider = remoteDataSourceProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
    this.defaultDispatcherProvider = defaultDispatcherProvider;
  }

  @Override
  public DefaultJackpotRepository get() {
    return newInstance(remoteDataSourceProvider.get(), ioDispatcherProvider.get(), defaultDispatcherProvider.get());
  }

  public static DefaultJackpotRepository_Factory create(
      Provider<JackpotRemoteDataSource> remoteDataSourceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider,
      Provider<CoroutineDispatcher> defaultDispatcherProvider) {
    return new DefaultJackpotRepository_Factory(remoteDataSourceProvider, ioDispatcherProvider, defaultDispatcherProvider);
  }

  public static DefaultJackpotRepository newInstance(JackpotRemoteDataSource remoteDataSource,
      CoroutineDispatcher ioDispatcher, CoroutineDispatcher defaultDispatcher) {
    return new DefaultJackpotRepository(remoteDataSource, ioDispatcher, defaultDispatcher);
  }
}
