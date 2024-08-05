package dz11;

class Woman extends Person {
    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public boolean isRetired() {
        return this.age > 60;
    }

    public void registerPartnership(Man man) {
        this.partner = man;
        man.setPartner(this);
        this.setLastName(man.getLastName());
    }

    public void deregisterPartnership(boolean revertLastName) {
        if (this.partner != null && this.partner instanceof Man) {
            Man man = (Man) this.partner;
            if (revertLastName) {
                this.setLastName(this.firstName + " (reverted)");
            }
            man.setPartner(null);
        }
        this.partner = null;
    }
}

