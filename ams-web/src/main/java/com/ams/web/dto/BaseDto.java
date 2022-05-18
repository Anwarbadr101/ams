/**
 * 
 */
package com.ams.web.dto;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @createdBy: Anwar.Badr
 *
 */
@Data
public class BaseDto<ID extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8372024569764349169L;
	
	private ID id;

}
