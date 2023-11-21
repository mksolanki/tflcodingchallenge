/*
 * Transport for London Unified API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;

/**
 * TflApiPresentationEntitiesRoadCorridor
 */
@javax.annotation.processing.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-11-16T18:01:38.204Z")
public class TflApiPresentationEntitiesRoadCorridor {
  @SerializedName("id")
  private String id = null;

  @SerializedName("displayName")
  private String displayName = null;

  @SerializedName("group")
  private String group = null;

  @SerializedName("statusSeverity")
  private String statusSeverity = null;

  @SerializedName("statusSeverityDescription")
  private String statusSeverityDescription = null;

  @SerializedName("bounds")
  private String bounds = null;

  @SerializedName("envelope")
  private String envelope = null;

  @SerializedName("statusAggregationStartDate")
  private OffsetDateTime statusAggregationStartDate = null;

  @SerializedName("statusAggregationEndDate")
  private OffsetDateTime statusAggregationEndDate = null;

  @SerializedName("url")
  private String url = null;

  public TflApiPresentationEntitiesRoadCorridor id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The Id of the Corridor e.g. \&quot;A406\&quot;
   * @return id
  **/
  @ApiModelProperty(value = "The Id of the Corridor e.g. \"A406\"")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TflApiPresentationEntitiesRoadCorridor displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * The display name of the Corridor e.g. \&quot;North Circular (A406)\&quot;. This              may be identical to the Id.
   * @return displayName
  **/
  @ApiModelProperty(value = "The display name of the Corridor e.g. \"North Circular (A406)\". This              may be identical to the Id.")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public TflApiPresentationEntitiesRoadCorridor group(String group) {
    this.group = group;
    return this;
  }

   /**
   * The group name of the Corridor e.g. \&quot;Central London\&quot;. Most corridors are not grouped, in which case this field can be null.
   * @return group
  **/
  @ApiModelProperty(value = "The group name of the Corridor e.g. \"Central London\". Most corridors are not grouped, in which case this field can be null.")
  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public TflApiPresentationEntitiesRoadCorridor statusSeverity(String statusSeverity) {
    this.statusSeverity = statusSeverity;
    return this;
  }

   /**
   * Standard multi-mode status severity code
   * @return statusSeverity
  **/
  @ApiModelProperty(value = "Standard multi-mode status severity code")
  public String getStatusSeverity() {
    return statusSeverity;
  }

  public void setStatusSeverity(String statusSeverity) {
    this.statusSeverity = statusSeverity;
  }

  public TflApiPresentationEntitiesRoadCorridor statusSeverityDescription(String statusSeverityDescription) {
    this.statusSeverityDescription = statusSeverityDescription;
    return this;
  }

   /**
   * Description of the status severity as applied to RoadCorridors
   * @return statusSeverityDescription
  **/
  @ApiModelProperty(value = "Description of the status severity as applied to RoadCorridors")
  public String getStatusSeverityDescription() {
    return statusSeverityDescription;
  }

  public void setStatusSeverityDescription(String statusSeverityDescription) {
    this.statusSeverityDescription = statusSeverityDescription;
  }

  public TflApiPresentationEntitiesRoadCorridor bounds(String bounds) {
    this.bounds = bounds;
    return this;
  }

   /**
   * The Bounds of the Corridor, given by the south-east followed by the north-west co-ordinate              pair in geoJSON format e.g. \&quot;[[-1.241531,51.242151],[1.641223,53.765721]]\&quot;
   * @return bounds
  **/
  @ApiModelProperty(value = "The Bounds of the Corridor, given by the south-east followed by the north-west co-ordinate              pair in geoJSON format e.g. \"[[-1.241531,51.242151],[1.641223,53.765721]]\"")
  public String getBounds() {
    return bounds;
  }

  public void setBounds(String bounds) {
    this.bounds = bounds;
  }

  public TflApiPresentationEntitiesRoadCorridor envelope(String envelope) {
    this.envelope = envelope;
    return this;
  }

   /**
   * The Envelope of the Corridor, given by the corner co-ordinates of a rectangular (four-point) polygon              in geoJSON format e.g. \&quot;[[-1.241531,51.242151],[-1.241531,53.765721],[1.641223,53.765721],[1.641223,51.242151]]\&quot;
   * @return envelope
  **/
  @ApiModelProperty(value = "The Envelope of the Corridor, given by the corner co-ordinates of a rectangular (four-point) polygon              in geoJSON format e.g. \"[[-1.241531,51.242151],[-1.241531,53.765721],[1.641223,53.765721],[1.641223,51.242151]]\"")
  public String getEnvelope() {
    return envelope;
  }

  public void setEnvelope(String envelope) {
    this.envelope = envelope;
  }

  public TflApiPresentationEntitiesRoadCorridor statusAggregationStartDate(OffsetDateTime statusAggregationStartDate) {
    this.statusAggregationStartDate = statusAggregationStartDate;
    return this;
  }

   /**
   * The start of the period over which status has been aggregated, or null if this is the current corridor status.
   * @return statusAggregationStartDate
  **/
  @ApiModelProperty(value = "The start of the period over which status has been aggregated, or null if this is the current corridor status.")
  public OffsetDateTime getStatusAggregationStartDate() {
    return statusAggregationStartDate;
  }

  public void setStatusAggregationStartDate(OffsetDateTime statusAggregationStartDate) {
    this.statusAggregationStartDate = statusAggregationStartDate;
  }

  public TflApiPresentationEntitiesRoadCorridor statusAggregationEndDate(OffsetDateTime statusAggregationEndDate) {
    this.statusAggregationEndDate = statusAggregationEndDate;
    return this;
  }

   /**
   * The end of the period over which status has been aggregated, or null if this is the current corridor status.
   * @return statusAggregationEndDate
  **/
  @ApiModelProperty(value = "The end of the period over which status has been aggregated, or null if this is the current corridor status.")
  public OffsetDateTime getStatusAggregationEndDate() {
    return statusAggregationEndDate;
  }

  public void setStatusAggregationEndDate(OffsetDateTime statusAggregationEndDate) {
    this.statusAggregationEndDate = statusAggregationEndDate;
  }

  public TflApiPresentationEntitiesRoadCorridor url(String url) {
    this.url = url;
    return this;
  }

   /**
   * URL to retrieve this Corridor.
   * @return url
  **/
  @ApiModelProperty(value = "URL to retrieve this Corridor.")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TflApiPresentationEntitiesRoadCorridor tflApiPresentationEntitiesRoadCorridor = (TflApiPresentationEntitiesRoadCorridor) o;
    return Objects.equals(this.id, tflApiPresentationEntitiesRoadCorridor.id) &&
        Objects.equals(this.displayName, tflApiPresentationEntitiesRoadCorridor.displayName) &&
        Objects.equals(this.group, tflApiPresentationEntitiesRoadCorridor.group) &&
        Objects.equals(this.statusSeverity, tflApiPresentationEntitiesRoadCorridor.statusSeverity) &&
        Objects.equals(this.statusSeverityDescription, tflApiPresentationEntitiesRoadCorridor.statusSeverityDescription) &&
        Objects.equals(this.bounds, tflApiPresentationEntitiesRoadCorridor.bounds) &&
        Objects.equals(this.envelope, tflApiPresentationEntitiesRoadCorridor.envelope) &&
        Objects.equals(this.statusAggregationStartDate, tflApiPresentationEntitiesRoadCorridor.statusAggregationStartDate) &&
        Objects.equals(this.statusAggregationEndDate, tflApiPresentationEntitiesRoadCorridor.statusAggregationEndDate) &&
        Objects.equals(this.url, tflApiPresentationEntitiesRoadCorridor.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, displayName, group, statusSeverity, statusSeverityDescription, bounds, envelope, statusAggregationStartDate, statusAggregationEndDate, url);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TflApiPresentationEntitiesRoadCorridor {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    statusSeverity: ").append(toIndentedString(statusSeverity)).append("\n");
    sb.append("    statusSeverityDescription: ").append(toIndentedString(statusSeverityDescription)).append("\n");
    sb.append("    bounds: ").append(toIndentedString(bounds)).append("\n");
    sb.append("    envelope: ").append(toIndentedString(envelope)).append("\n");
    sb.append("    statusAggregationStartDate: ").append(toIndentedString(statusAggregationStartDate)).append("\n");
    sb.append("    statusAggregationEndDate: ").append(toIndentedString(statusAggregationEndDate)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

