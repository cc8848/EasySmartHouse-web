var sensor1Decorator = {
    getValue: function () {
        return delegate.getValue() * 100;
    },
    getLabel: function () {
        return 'decorated ' + delegate.getLabel();
    }
}
