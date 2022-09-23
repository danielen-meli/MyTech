package Model;

import com.mercadopago.resources.preference.Preference;
import com.mercadopago.resources.preference.PreferencePayer;
import com.mercadopago.resources.preference.PreferencePaymentMethods;


public class PreferenceDto {
  static Preference preference = new Preference();
  static PreferencePayer preferencePayer = new PreferencePayer();
  static PreferencePaymentMethods preferencePaymentMethods = new PreferencePaymentMethods();
  private final String id;
  private final String initPoint;
  private final String sandBoxInitPoint;

  public PreferenceDto(String id, String initPoint, String sandBoxInitPoint) {
    this.id = id;
    this.initPoint = initPoint;
    this.sandBoxInitPoint = sandBoxInitPoint;
  }

  public static class Builder {
    String id;
    String initPoint;
    String sandBoxInitPoint;

    public Builder idDto(String id) {
      this.id = id;
      return this;
    }
    public Builder initPointDto (String initPoint) {
      this.initPoint = initPoint;
      return this;
    }
    public Builder sandBoxDto(String sandBoxInitPoint) {
      this.sandBoxInitPoint = sandBoxInitPoint;
      return this;
    }
    public PreferenceDto build() {
      return new PreferenceDto(id, initPoint, sandBoxInitPoint);
    }

  }

}
