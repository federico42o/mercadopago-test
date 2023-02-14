package com.f42o.app.services;

import com.f42o.app.dto.PreferenceDTO;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

public interface IPreferenceService {
	Preference create(PreferenceDTO dto) throws MPException, MPApiException;

}
