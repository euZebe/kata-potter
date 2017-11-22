package fr.exia.katapotter.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Price {
	
	private BigDecimal value;
	
	Price(double value) {
		this.value = new BigDecimal(value).setScale(2, RoundingMode.HALF_DOWN);
		this.value.setScale(2);
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	@Override
	public boolean equals(Object o) {
	    // self check
	    if (this == o)
	        return true;
	    // null check
	    if (o == null)
	        return false;
	    // type check and cast
	    if (getClass() != o.getClass())
	        return false;
	    // field comparison
	    return Objects.equals(this.value, ((Price)o).value);
	}
}
