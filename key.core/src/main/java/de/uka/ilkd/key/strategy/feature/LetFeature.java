/* This file is part of KeY - https://key-project.org
 * KeY is licensed under the GNU General Public License Version 2
 * SPDX-License-Identifier: GPL-2.0-only */
package de.uka.ilkd.key.strategy.feature;

import de.uka.ilkd.key.logic.PosInOccurrence;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.rule.RuleApp;
import de.uka.ilkd.key.strategy.RuleAppCost;
import de.uka.ilkd.key.strategy.termProjection.ProjectionToTerm;
import de.uka.ilkd.key.strategy.termProjection.TermBuffer;


/**
 * Feature for locally binding a <code>TermBuffer</code> to a certain value, namely to a term that
 * is generated by a <code>ProjectionToTerm</code>. This is mostly useful to make feature terms more
 * readable, and to avoid repeated evaluation of projections.
 */
public class LetFeature implements Feature {

    private final TermBuffer var;
    private final ProjectionToTerm value;
    private final Feature body;

    public static Feature create(TermBuffer var, ProjectionToTerm value, Feature body) {
        return new LetFeature(var, value, body);
    }

    private LetFeature(TermBuffer var, ProjectionToTerm value, Feature body) {
        this.var = var;
        this.value = value;
        this.body = body;
    }

    public RuleAppCost computeCost(RuleApp app, PosInOccurrence pos, Goal goal,
            MutableState mState) {
        final Term outerVarContent = var.getContent(mState);

        var.setContent(value.toTerm(app, pos, goal, mState), mState);
        final RuleAppCost res = body.computeCost(app, pos, goal, mState);

        var.setContent(outerVarContent, mState);
        return res;
    }

}
