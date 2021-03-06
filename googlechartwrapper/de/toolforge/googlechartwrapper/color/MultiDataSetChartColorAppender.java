package de.toolforge.googlechartwrapper.color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IExtendedFeatureAppender;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;


/**
 * 
 * @author steffan
 * 
 * @see IMultiDataSetChartColorable
 */
public class MultiDataSetChartColorAppender implements IExtendedFeatureAppender {

	private StringBuilder color = new StringBuilder();
	private String lastDelimiter = null;

	/**
	 * 
	 * @param chartColorList
	 * 
	 * @throws IllegalArgumentException
	 *             if chartColorList or member is {@code null}
	 */
	public void addChartColorSet(List<ChartColor> chartColorList) {

		if (chartColorList == null)
			throw new IllegalArgumentException("chartColorList can not be null");

		List<ChartColor> temp = Collections.unmodifiableList(chartColorList);

		
		for (ChartColor curent : temp) {
			if (curent == null)
				throw new IllegalArgumentException("member can not be null");
		}
		
		if(this.lastDelimiter != null)
		{
			this.color.append(this.lastDelimiter);
		}		
		
		for (ChartColor current : temp) {

			color.append(current.getColor().getMatchingColorHexValue());
			color.append("|");

		}
		
		if(this.color.length() > 0){
			this.color.deleteCharAt(this.color.length()-1);
		}
		
		this.lastDelimiter = ",";
	};

	/**
	 * 
	 * @param chartColor
	 * 
	 * @throws IllegalArgumentException
	 *             if chartColor is {@code null}
	 */
	public void addChartColor(ChartColor chartColor) {

		if (chartColor == null)
			throw new IllegalArgumentException("chartColor can not be null");
		
		if(this.lastDelimiter != null)
		{
			this.color.append(this.lastDelimiter);
		}
		
		
		this.color.append(chartColor
				.getColor().getMatchingColorHexValue());
			
		this.lastDelimiter = ",";
	};

	public List<AppendableFeature> getAppendableFeatures(
			List<? extends IFeatureAppender> otherAppenders) {

		List<AppendableFeature> feature = new ArrayList<AppendableFeature>();

		if (this.color.length() > 0) {
			feature.add(new AppendableFeature(color.toString(),
					ChartTypeFeature.ChartColor));
		}
		return feature;
	}

}
