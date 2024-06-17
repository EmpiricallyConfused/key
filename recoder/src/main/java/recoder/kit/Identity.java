/* This file was part of the RECODER library and protected by the LGPL.
 * This file is part of KeY since 2021 - https://key-project.org
 * KeY is licensed under the GNU General Public License Version 2
 * SPDX-License-Identifier: GPL-2.0-only */
package recoder.kit;

/**
 * Problem report indicating that the planned transformation is redundant. The syntactic
 * transformation itself can be skipped.
 * <p>
 * Instead of creating a new object, the {@link recoder.kit.Transformation#IDENTITY}constant should
 * be used.
 *
 * @author AL
 */
public class Identity extends Equivalence {
    Identity() {
        super();
    }
}
