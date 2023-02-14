package com.f42o.app.services;

import com.f42o.app.dto.PreferenceDTO;
import com.mercadopago.resources.preference.Preference;

public interface IPreferenceService {
	Preference create(PreferenceDTO dto);

}
