package org.gui.fracture;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.World;
import org.gui.ICase;
import org.jbox2d.fracture.materials.Diffusion;

/**
 * Testovaci scenar
 *
 * @author Marek Benovic
 */
public class Circle implements ICase {
    @Override
    public void init(World w) {
        {
            BodyDef bodyDef2 = new BodyDef();
            bodyDef2.type = BodyType.DYNAMIC;
            bodyDef2.position = new Vec2(10.0f, 10.0f);
            bodyDef2.angle = -0.6f; // otocenie
            bodyDef2.linearVelocity = new Vec2(0.0f, 0.0f); // smer pohybu
            bodyDef2.angularVelocity = 0.0f; //rotacia (rychlost rotacie)
            Body newBody = w.createBody(bodyDef2);
            CircleShape shape2 = new CircleShape();
            shape2.m_radius = 2.5f;
            Fixture f = newBody.createFixture(shape2, 1.0f);
            f.m_friction = 0.5f; // trenie
            f.m_restitution = 0.0f; //odrazivost
            f.m_material = new Diffusion();
            f.m_material.m_rigidity = 8.0f;
        }
    }
    
    @Override
    public String toString() {
        return "Circle";
    }
}
