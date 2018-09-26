package com.tks.sn.web.booldsuger.service;

import java.text.ParseException;

import com.tks.sn.common.SNResult;
import com.tks.sn.web.booldsuger.entity.SnUserBloodsugerDTO;

/**
 * 
 * @author gl
 *
 */
public interface IBloodSugerService {
	SNResult receiveBSData(SnUserBloodsugerDTO dto) throws ParseException;
}
