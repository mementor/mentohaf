/*
 *  This file is part of bdew's Haven & Hearth modified client.
 *  Copyright (C) 2015 bdew
 *
 *  Redistribution and/or modification of this file is subject to the
 *  terms of the GNU Lesser General Public License, version 3, as
 *  published by the Free Software Foundation.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Other parts of this source tree adhere to other copying
 *  rights. Please see the file `COPYING' in the root directory of the
 *  source tree for details.
 *
 *  A copy the GNU Lesser General Public License is distributed along
 *  with the source tree of which this file is a part in the file
 *  `doc/LPGL-3'. If it is missing for any reason, please see the Free
 *  Software Foundation's website at <http://www.fsf.org/>, or write
 *  to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 *  Boston, MA 02111-1307 USA
 */

package haven;

public class ConfigSettingBoolean {
    public String id;
    public String name;
    public boolean enabled;

    public ConfigSettingBoolean(String id, String name, boolean defaultState) {
        this.id = id;
        this.name = name;
        this.enabled = Utils.getprefb(id, defaultState);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean state) {
        enabled = state;
        Utils.setprefb(id, state);
    }

    public void toggle() {
        setEnabled(!isEnabled());
    }

    public CheckBox makeCheckBox() {
        return new CheckBox(name) {
            @Override
            public void tick(double dt) {
                a = isEnabled();
                super.tick(dt);
            }

            @Override
            public void changed(boolean val) {
                setEnabled(val);
                super.changed(val);
            }
        };
    }
}
