package com.digitain.feature.jackpot.viewmodel;

import com.digitain.core.domain.usecase.GetJackpotDataUseCase;
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
public final class JackpotViewModel_Factory implements Factory<JackpotViewModel> {
  private final Provider<GetJackpotDataUseCase> getJackpotDataUseCaseProvider;

  private JackpotViewModel_Factory(Provider<GetJackpotDataUseCase> getJackpotDataUseCaseProvider) {
    this.getJackpotDataUseCaseProvider = getJackpotDataUseCaseProvider;
  }

  @Override
  public JackpotViewModel get() {
    return newInstance(getJackpotDataUseCaseProvider.get());
  }

  public static JackpotViewModel_Factory create(
      Provider<GetJackpotDataUseCase> getJackpotDataUseCaseProvider) {
    return new JackpotViewModel_Factory(getJackpotDataUseCaseProvider);
  }

  public static JackpotViewModel newInstance(GetJackpotDataUseCase getJackpotDataUseCase) {
    return new JackpotViewModel(getJackpotDataUseCase);
  }
}
