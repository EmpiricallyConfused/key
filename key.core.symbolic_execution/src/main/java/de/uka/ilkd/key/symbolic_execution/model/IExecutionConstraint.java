/* This file is part of KeY - https://key-project.org
 * KeY is licensed under the GNU General Public License Version 2
 * SPDX-License-Identifier: GPL-2.0-only */
package de.uka.ilkd.key.symbolic_execution.model;

import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.symbolic_execution.model.impl.ExecutionConstraint;

/**
 * <p>
 * A constrained considered during symbolic execution.
 * </p>
 * <p>
 * The default implementation is {@link ExecutionConstraint} which is instantiated lazily by the
 * {@link IExecutionNode} and {@link IExecutionValue} implementations.
 * </p>
 *
 * @author Martin Hentschel
 * @see IExecutionNode
 * @see IExecutionValue
 * @see ExecutionConstraint
 */
public interface IExecutionConstraint extends IExecutionElement {
    /**
     * Returns the {@link Term} representing the constraint.
     *
     * @return The {@link Term} representing the constraint.
     */
    Term getTerm();
}
