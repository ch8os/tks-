package com.tks.third.web.booldsuger.service;

import java.text.ParseException;

import com.tks.third.common.SNResult;
import com.tks.third.web.booldsuger.entity.SnUserBloodsugerDTO;

/**
 * 
 * @author gl
 *
 */
public interface IBloodSugerService {
	SNResult receiveBSData(SnUserBloodsugerDTO dto) throws ParseException;
}
