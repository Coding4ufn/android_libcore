/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tests.api.org.xml.sax;

import junit.framework.TestCase;

import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.AttributeListImpl;
import org.xml.sax.helpers.LocatorImpl;

@SuppressWarnings("deprecation")
public class HandlerBaseTest extends TestCase {

    /*
     * Note: most of the tests have to check for an empty implementation of the
     * respective methods and, as a result, are somewhat trivial.
     */

    private HandlerBase h = new HandlerBase();

    public void testResolveEntity() {
        try {
            h.resolveEntity("publicID", "systemID");
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public void testNotationDecl() {
        h.notationDecl("name", "publicID", "systemID");
    }

    public void testUnparsedEntityDecl() {
        h.unparsedEntityDecl("name", "publicID", "systemID", "notationName");
    }

    public void testSetDocumentLocator() {
        h.setDocumentLocator(new LocatorImpl());
    }

    public void testStartDocument() {
        try {
            h.startDocument();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public void testEndDocument() {
        try {
            h.endDocument();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public void testStartElement() {
        try {
            h.startElement("name", new AttributeListImpl());
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public void testEndElement() {
        try {
            h.endElement("name");
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public void testCharacters() {
        try {
            h.characters("The quick brown fox".toCharArray(), 4, 11);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public void testIgnorableWhitespace() {
        try {
            h.ignorableWhitespace("                   ".toCharArray(), 4, 11);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public void testProcessingInstruction() {
        try {
            h.processingInstruction("target", "data");
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public void testWarning() {
        try {
            h.warning(new SAXParseException("Foo", new LocatorImpl()));
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public void testError() {
        try {
            h.error(new SAXParseException("Foo", new LocatorImpl()));
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public void testFatalError() {
        // Ordinary case
        try {
            h.fatalError(new SAXParseException("Foo", new LocatorImpl()));
            fail("SAXException expected");
        } catch (SAXException e) {
            // Expected
        }

        // No exception
        try {
            h.fatalError(null);
            fail("NullPointerException expected");
        } catch (SAXException e) {
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
            // Expected
        }

    }

}
