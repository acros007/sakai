/**
 * $Id$
 * $URL$
 * ActionReturn.java - entity-broker - Jul 25, 2008 4:19:15 PM - azeckoski
 **************************************************************************
 * Copyright (c) 2008 Aaron Zeckoski
 * Licensed under the Apache License, Version 2.0
 * 
 * A copy of the Apache License has been included in this 
 * distribution and is available at: http://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * Aaron Zeckoski (azeckoski @ gmail.com) (aaronz @ vt.edu) (aaron @ caret.cam.ac.uk)
 */

package org.sakaiproject.entitybroker.entityprovider.extension;

import java.io.OutputStream;
import java.util.List;


/**
 * A special object used to return specialized results from a custom action execution,
 * includes fields to allow for handling of encoded binary data and to indicate
 * that entity action processing should continue as it would have if there
 * had been no custom action call (rather than exiting the standard chain)
 * 
 * @author Aaron Zeckoski (azeckoski @ gmail.com)
 */
public class ActionReturn {

   /**
    * The encoding to use for the output when it is returned
    */
   public String encoding = Formats.UTF_8;
   /**
    * The MIME type to use for the output when it is returned
    */
   public String mimeType = Formats.XML_MIME_TYPE;
   /**
    * the data to output (should use a provided OutputStream), can be binary, leave this null if not used
    */
   public OutputStream output;
   /**
    * the output data in string form, leave this null if not used
    */
   public String outputString;
   /**
    * An entity object to return, leave as null if not used
    */
   public Object entityData;
   /**
    * A List of entities to return, leave as null if not used
    */
   public List<?> entitiesList;
   /**
    * Indicates the format (from {@link Formats}) to return the entity data in if there is any,
    * if using an outputstream, use encoding and mimetype
    */
   public String format;
   
   /**
    * Set the outputstream to indicate it was used,
    * uses default encoding UTF-8 and type of text/xml
    * @param output
    */
   public ActionReturn(OutputStream output) {
      this.output = output;
   }
   
   /**
    * Set a string of data to return,
    * uses default encoding UTF-8 and type of text/xml
    * @param outputString
    */
   public ActionReturn(String outputString) {
      this.outputString = outputString;
   }

   /**
    * Create a return that is appropriate for sending binary data or a large chunk of text
    * @param encoding
    * @param mimeType
    * @param output the stream of binary data
    */
   public ActionReturn(String encoding, String mimeType, OutputStream output) {
      this.encoding = encoding;
      this.mimeType = mimeType;
      this.output = output;
   }

   /**
    * Create a return that is appropriate for sending back a string
    * @param encoding
    * @param mimeType
    * @param outputString the string value
    */
   public ActionReturn(String encoding, String mimeType, String outputString) {
      this.encoding = encoding;
      this.mimeType = mimeType;
      this.outputString = outputString;
   }

   /**
    * Create a return that is appropriate for sending back an entity
    * @param entityData an entity
    * @param format (optional) the format to return this data in (from {@link Formats}), e.g. Formats.XML
    */
   public ActionReturn(Object entityData, String format) {
      this.entityData = entityData;
      this.format = format;
   }

   /**
    * Create a return that is appropriate for sending back a list of entities
    * @param entityData a List of entities (can be empty)
    * @param format (optional) the format to return this data in (from {@link Formats}), e.g. Formats.XML
    */
   public ActionReturn(List<?> entitiesList, String format) {
      this.entitiesList = entitiesList;
      this.format = format;
   }

}
