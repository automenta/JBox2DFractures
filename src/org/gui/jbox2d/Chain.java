package org.gui.jbox2d;

import org.gui.ICase;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.joints.RevoluteJointDef;

/**
 * @author Daniel Murphy
 */
public class Chain implements ICase {

    @Override
    public void init(World w) {


        Body ground = null;
        {
            BodyDef bd = new BodyDef();
            ground = w.createBody(bd);

            EdgeShape shape = new EdgeShape();
            shape.set(new Vec2(-40.0f, 0.0f), new Vec2(40.0f, 0.0f));
            ground.createFixture(shape, 0.0f);
        }

        {

            FixtureDef fd = new FixtureDef(
                    PolygonShape.box(0.6f, 0.125f), 20f, 0.2f);

            RevoluteJointDef jd = new RevoluteJointDef();
            jd.collideConnected = false;

            final float y = 25.0f;
            Body prevBody = ground;
            for (int i = 0; i < 30; ++i) {
                BodyDef bd = new BodyDef();
                bd.type = BodyType.DYNAMIC;
                bd.position.set(0.5f + i, y);
                Body body = w.createBody(bd);
                body.createFixture(fd);

                Vec2 anchor = new Vec2(i, y);
                jd.initialize(prevBody, body, anchor);
                w.createJoint(jd);

                prevBody = body;
            }
        }
    }


}