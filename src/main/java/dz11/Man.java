package dz11;

class Man extends Person {
    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public boolean isRetired() {
        return this.age > 65;
    }

    public void registerPartnership(Woman woman) {
        this.partner = woman;
        woman.setPartner(this);
        woman.setLastName(this.lastName);
    }

    public void deregisterPartnership(boolean revertLastName) {
        if (this.partner != null && this.partner instanceof Woman) {
            Woman woman = (Woman) this.partner;
            if (revertLastName) {
                woman.setLastName(woman.getFirstName() + " (reverted)");
            }
            woman.setPartner(null);
        }
        this.partner = null;
    }
}