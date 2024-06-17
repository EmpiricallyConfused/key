/* This file was part of the RECODER library and protected by the LGPL.
 * This file is part of KeY since 2021 - https://key-project.org
 * KeY is licensed under the GNU General Public License Version 2
 * SPDX-License-Identifier: GPL-2.0-only */
package recoder.abstraction;

/**
 * A program model element representing variables.
 *
 * @author AL
 * @author RN
 */
public interface Variable extends ProgramModelElement {

    /**
     * Checks if this variable is final.
     *
     * @return <CODE>true</CODE> if this variable is final, <CODE>false
     * </CODE> otherwise.
     */
    boolean isFinal();

    /**
     * Returns the type of this variable.
     *
     * @return the type of this variable.
     */
    Type getType();
}
