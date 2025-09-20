package com.digitain.core.domain.usecase;

import com.digitain.core.domain.repository.JackpotRepository;
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
public final class GetJackpotDataUseCase_Factory implements Factory<GetJackpotDataUseCase> {
  private final Provider<JackpotRepository> jackpotRepositoryProvider;

  private GetJackpotDataUseCase_Factory(Provider<JackpotRepository> jackpotRepositoryProvider) {
    this.jackpotRepositoryProvider = jackpotRepositoryProvider;
  }

  @Override
  public GetJackpotDataUseCase get() {
    return newInstance(jackpotRepositoryProvider.get());
  }

  public static GetJackpotDataUseCase_Factory create(
      Provider<JackpotRepository> jackpotRepositoryProvider) {
    return new GetJackpotDataUseCase_Factory(jackpotRepositoryProvider);
  }

  public static GetJackpotDataUseCase newInstance(JackpotRepository jackpotRepository) {
    return new GetJackpotDataUseCase(jackpotRepository);
  }
}
