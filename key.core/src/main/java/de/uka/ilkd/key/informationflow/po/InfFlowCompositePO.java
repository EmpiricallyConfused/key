/* This file is part of KeY - https://key-project.org
 * KeY is licensed under the GNU General Public License Version 2
 * SPDX-License-Identifier: GPL-2.0-only */
package de.uka.ilkd.key.informationflow.po;


/**
 *
 * @author christoph
 */
public interface InfFlowCompositePO extends InfFlowPO {

    AbstractInfFlowPO getChildPO();

}
