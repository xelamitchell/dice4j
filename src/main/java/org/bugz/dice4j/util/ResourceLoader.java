package org.bugz.dice4j.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * This Class is responsible for acquiring resources (internationalisation 
 * <code>ResourceBundle</code>s from .properties files, for example) for the
 * API's dice.<br/>
 * <code>ResourceLoader</code> has a default Locale set to the system's Locale
 * so that, if only the simple filename accepting methods are used, the same
 * language resource should be returned (unless the resource of that particular
 * language does not exist, in which case the default language resource will be
 * returned).<br/>
 * <b>There should always be a default language .properties file present in the
 * Classpath.</b>
 *
 * @version 0.0.1 20.07.2007
 * @author bugz
 */
/*
 * TODO ResourceLoader should keep a collection of previously loaded resources
 * (possibly in a TreeModel). If the resource has been previously loaded and is
 * still within the collection (there should be a mechanism which removes items
 * from the collection, similar to a garbage collection, possibly a Thread
 * running a remove job in the background), it is returned, rather than loading
 * the resource again.
 */
public final class ResourceLoader {
    
    /**
     * Returns the Locale the <code>PropertyLoader</code> is currently using
     * for getMethods which only accept the filename of the .properties file.<br>
     * This Locale can be changed using the method setLocale(Locale l).
     *
     * @return the current Locale the <code>PropertyLoader</code> is using for
     * default loads.
     * @see #setLocale(Locale l)
     */
    public static Locale getLocale() {
        return defaultLocale;
    }
    
    /**
     * Sets the Locale the <code>PropertyLoader</code> will use to load
     * resource files which do not have a specified Locale.
     *
     * @param l the new Locale the <code>PropertyLoader</code> should use to
     * load .properties files.
     */
    public static void setLocale(Locale l) {
        defaultLocale = l;
    }
    
    /**
     * Returns the required resource based on the name of the file and the
     * <code>PropertyLoader</code>'s default Locale.
     * 
     * @param filename the name of the resource to be loaded.
     * @return a ResourceBundle loaded according to the name and
     * <code>PropertyLoader</code>'s default Locale.
     * @throws <code>IllegalArgumentException</code> if the filename is null.
     */
    public static ResourceBundle getBundle(String filename) throws IllegalArgumentException {
        return getBundle(filename, getLocale());
    }
    
    /**
     * Returns the required resource based in the name of the file and the
     * requested Locale.
     * 
     * @param filename the name of the resource to be loaded.
     * @param locale the language of the resource to be loaded.
     * @return a ResourceBundle loaded according to the specified filename and
     * Locale.
     * @throws <code>IllegalArgumentException</code> if the filename is null.
     */
    public static ResourceBundle getBundle(String filename, Locale locale) throws IllegalArgumentException {
        
        if(filename == null) {
            throw new IllegalArgumentException("Filename cannot be null");
        }
        
        if(i18n == null || !i18n.getLocale().equals(locale)) {
            i18n = ResourceBundle.getBundle(filename, locale);
        }
        
        return i18n;
    }
    
    /**
     * Returns the contents of a .properties file packaged as a
     * java.util.Properties Class according to the <code>PropertyLoader</code>'s
     * default Locale.
     *
     * @param filename the name of the resource to be loaded.
     * @return a Properties Class containing the key-value pair of the resource
     * file.
     * @throws <code>IllegalArgumentException</code> if the filename is null.
     */
    public static Properties getProperties(String filename) throws IllegalArgumentException {
        return getProperties(filename, getLocale());
    }
    
    /**
     * Returns the contents of a .properties file packaged as a
     * java.util.Properties Class according to the specified Locale.
     *
     * @param filename the name of the resource to be loaded.
     * @param locale the language of the resource to be loaded.
     * @return a Properties Class containing the key-value pair of the resource
     * file.
     * @throws <code>IllegalArgumentException</code> if the filename is null.
     */
    public static Properties getProperties(String filename, Locale locale) throws IllegalArgumentException {
        return null;
    }
    
    /**
     * Returns the contents of a .properties file resource packaged as a
     * java.util.Collection. The file loaded is the one that either matches the
     * <code>PropertyLoader</code>'s default Locale.
     *
     * @param filename the name of the resource to be loaded.
     * @return a Collection containing all of the items in the specified
     * .property file.
     * @throws <code>IllegalArgumentException</code> if the filename is null.
     */
    public static Collection<String> getCollection(String filename) throws IllegalArgumentException {
        return getCollection(filename, getLocale());
    }
    
    /**
     * Returns the contents of a .properties file resource packaged as a
     * java.util.Collection.
     * 
     * @param filename the name of the resource to be loaded.
     * @param locale the language of the resource to be loaded.
     * @return a Collection containing all of the items in the specified
     * .property file.
     * @throws <code>IllegalArgumentException</code> if the filename is null.
     */
    public static Collection<String> getCollection(String filename, Locale locale) throws IllegalArgumentException {
        
        Collection<String> c = new ArrayList<String>();
        ResourceBundle r = getBundle(filename, locale);
        
        /*
        for(Enumeration<String> s : r.getKeys()) {
            c.add(r.getString(s.toString()));
        }
         */
        
        return c;
    }
    
    /** The reference to the most recent ResourceBundle loaded. */
    private static ResourceBundle i18n = null;
    /**
     * The <code>PropertyLoader</code>'s default Locale. This may be
     * changed by the user.
     */
    private static Locale defaultLocale = Locale.getDefault();
    
}
