/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.xtext.xproperties;

import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.merge.BatchMerger;
import org.eclipse.emf.compare.merge.IMerger;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.xtext.xproperties.IModelMerger;

@SuppressWarnings("all")
public class GenericModelMerger implements IModelMerger {
  @Override
  public EObject findMatchingObject(final EObject model, final EObject object) {
    Resource _eResource = model.eResource();
    Resource _eResource_1 = object.eResource();
    final DefaultComparisonScope scope = new DefaultComparisonScope(_eResource, _eResource_1, null);
    EMFCompare.Builder _builder = EMFCompare.builder();
    EMFCompare _build = _builder.build();
    final Comparison comparison = _build.compare(scope);
    Match _match = comparison.getMatch(object);
    return _match.getLeft();
  }
  
  protected List<EObject> findMatchingObjects(final EObject model, final Collection<EObject> objects) {
    boolean _isEmpty = objects.isEmpty();
    if (_isEmpty) {
      throw new IllegalArgumentException();
    }
    Resource _eResource = model.eResource();
    EObject _head = IterableExtensions.<EObject>head(objects);
    Resource _eResource_1 = _head.eResource();
    final DefaultComparisonScope scope = new DefaultComparisonScope(_eResource, _eResource_1, null);
    EMFCompare.Builder _builder = EMFCompare.builder();
    EMFCompare _build = _builder.build();
    final Comparison comparison = _build.compare(scope);
    final Function1<EObject, EObject> _function = new Function1<EObject, EObject>() {
      @Override
      public EObject apply(final EObject object) {
        Match _match = comparison.getMatch(object);
        return _match.getLeft();
      }
    };
    Iterable<EObject> _map = IterableExtensions.<EObject, EObject>map(objects, _function);
    Iterable<EObject> _filterNull = IterableExtensions.<EObject>filterNull(_map);
    return IterableExtensions.<EObject>toList(_filterNull);
  }
  
  @Override
  public void merge(final EObject source, final EObject destination) {
    final DefaultComparisonScope scope = new DefaultComparisonScope(destination, source, null);
    EMFCompare.Builder _builder = EMFCompare.builder();
    EMFCompare _build = _builder.build();
    final Comparison comparison = _build.compare(scope);
    EMFCompareRCPPlugin _default = EMFCompareRCPPlugin.getDefault();
    IMerger.Registry _mergerRegistry = _default.getMergerRegistry();
    final BatchMerger merger = new BatchMerger(_mergerRegistry);
    EList<Diff> _differences = comparison.getDifferences();
    BasicMonitor _basicMonitor = new BasicMonitor();
    merger.copyAllRightToLeft(_differences, _basicMonitor);
  }
  
  @Override
  public void apply(final Notification notification, final EObject destination) {
    final Object feature = notification.getFeature();
    if ((feature instanceof EStructuralFeature)) {
      boolean _and = false;
      if (!(feature instanceof EReference)) {
        _and = false;
      } else {
        boolean _isContainer = ((EReference) feature).isContainer();
        _and = _isContainer;
      }
      GenericModelMerger.assertNot(_and);
      int _eventType = notification.getEventType();
      switch (_eventType) {
        case Notification.ADD:
          boolean _isMany = ((EStructuralFeature)feature).isMany();
          GenericModelMerger.assertThat(_isMany);
          Object _eGet = destination.eGet(((EStructuralFeature)feature));
          final Collection<Object> collection = ((Collection<Object>) _eGet);
          if ((feature instanceof EReference)) {
            boolean _isContainment = ((EReference)feature).isContainment();
            if (_isContainment) {
              Object _newValue = notification.getNewValue();
              EObject _copy = EcoreUtil.<EObject>copy(((EObject) _newValue));
              collection.add(_copy);
            } else {
              Object _newValue_1 = notification.getNewValue();
              EObject _findMatchingObject = this.findMatchingObject(destination, ((EObject) _newValue_1));
              collection.add(_findMatchingObject);
            }
          } else {
            Object _newValue_2 = notification.getNewValue();
            collection.add(_newValue_2);
          }
          break;
        case Notification.ADD_MANY:
          boolean _isMany_1 = ((EStructuralFeature)feature).isMany();
          GenericModelMerger.assertThat(_isMany_1);
          Object _eGet_1 = destination.eGet(((EStructuralFeature)feature));
          final Collection<Object> collection_1 = ((Collection<Object>) _eGet_1);
          if ((feature instanceof EReference)) {
            boolean _isContainment_1 = ((EReference)feature).isContainment();
            if (_isContainment_1) {
              Object _newValue_3 = notification.getNewValue();
              final Function1<EObject, EObject> _function = new Function1<EObject, EObject>() {
                @Override
                public EObject apply(final EObject it) {
                  return EcoreUtil.<EObject>copy(it);
                }
              };
              Iterable<EObject> _map = IterableExtensions.<EObject, EObject>map(((Collection<EObject>) _newValue_3), _function);
              Iterables.<Object>addAll(collection_1, _map);
            } else {
              Object _newValue_4 = notification.getNewValue();
              List<EObject> _findMatchingObjects = this.findMatchingObjects(destination, ((Collection<EObject>) _newValue_4));
              collection_1.addAll(_findMatchingObjects);
            }
          } else {
            Object _newValue_5 = notification.getNewValue();
            collection_1.addAll(((Collection<Object>) _newValue_5));
          }
          break;
        case Notification.REMOVE:
          boolean _isMany_2 = ((EStructuralFeature)feature).isMany();
          GenericModelMerger.assertThat(_isMany_2);
          Object _eGet_2 = destination.eGet(((EStructuralFeature)feature));
          final Collection<Object> collection_2 = ((Collection<Object>) _eGet_2);
          if ((feature instanceof EReference)) {
            Object _oldValue = notification.getOldValue();
            EObject _findMatchingObject_1 = this.findMatchingObject(destination, ((EObject) _oldValue));
            collection_2.remove(_findMatchingObject_1);
          } else {
            Object _oldValue_1 = notification.getOldValue();
            collection_2.remove(_oldValue_1);
          }
          break;
        case Notification.REMOVE_MANY:
          boolean _isMany_3 = ((EStructuralFeature)feature).isMany();
          GenericModelMerger.assertThat(_isMany_3);
          Object _eGet_3 = destination.eGet(((EStructuralFeature)feature));
          final Collection<Object> collection_3 = ((Collection<Object>) _eGet_3);
          if ((feature instanceof EReference)) {
            Object _oldValue_2 = notification.getOldValue();
            List<EObject> _findMatchingObjects_1 = this.findMatchingObjects(destination, ((Collection<EObject>) _oldValue_2));
            collection_3.removeAll(_findMatchingObjects_1);
          } else {
            Object _oldValue_3 = notification.getOldValue();
            collection_3.removeAll(((Collection<Object>) _oldValue_3));
          }
          break;
        case Notification.SET:
          boolean _isMany_4 = ((EStructuralFeature)feature).isMany();
          GenericModelMerger.assertNot(_isMany_4);
          if ((feature instanceof EReference)) {
            boolean _isContainment_2 = ((EReference)feature).isContainment();
            if (_isContainment_2) {
              Object _newValue_6 = notification.getNewValue();
              EObject _copy_1 = EcoreUtil.<EObject>copy(((EObject) _newValue_6));
              destination.eSet(((EStructuralFeature)feature), _copy_1);
            } else {
              Object _newValue_7 = notification.getNewValue();
              EObject _findMatchingObject_2 = this.findMatchingObject(destination, ((EObject) _newValue_7));
              destination.eSet(((EStructuralFeature)feature), _findMatchingObject_2);
            }
          } else {
            Object _newValue_8 = notification.getNewValue();
            destination.eSet(((EStructuralFeature)feature), _newValue_8);
          }
          break;
        case Notification.UNSET:
          boolean _isMany_5 = ((EStructuralFeature)feature).isMany();
          GenericModelMerger.assertNot(_isMany_5);
          destination.eUnset(((EStructuralFeature)feature));
          break;
      }
    } else {
      throw new UnsupportedOperationException((("Feature " + feature) + " not supported."));
    }
  }
  
  private static void assertThat(final boolean b) {
    try {
      if ((!b)) {
        throw new AssertionError();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static void assertNot(final boolean b) {
    GenericModelMerger.assertThat((!b));
  }
}
